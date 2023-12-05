package wiki.chenxun.demo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xun.chen
 */
public class FileExportUtil {


    /**
     *  thread pool on test
     */
    private static ExecutorService executorService= Executors.newFixedThreadPool(8);


    public static  <T>  void export(FileExportParam fileExportParam,DataCounter dataCounter,
                       DataLoader<T> dataLoader){

        // count of data
        int dataCount=dataCounter.count();

        // calc sheet and file
        int fileCount=dataCount/ fileExportParam.getMaxRowsOnSheet()/fileExportParam.getMaxSheetsOnExcel()+1;

        FileBuffer<T> fileBuffer=new FileBuffer<>(fileCount,
                fileExportParam.getMaxSheetsOnExcel());


        executorService.submit(()->{
            int offset =0;
            int limit =100;

            while (true){
               List<T> dataList= dataLoader.loadOnce(offset,limit);
               if(dataList.isEmpty()){
                   // no data
                   fileBuffer.shutDown();
                   break;
               }
               // writer to buffer

            }
        });

        // start to save file
        fileBuffer.start(executorService);






    }


    @FunctionalInterface
    public interface DataCounter{

        /**
         * data of count
         * @return
         */
        int count();
    }

    @FunctionalInterface
    public interface  DataLoader<T>{

        /**
         *  load data on once
         * @return
         */
        List<T> loadOnce(int offset,int limit);

    }

}
