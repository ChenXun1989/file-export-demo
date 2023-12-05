package wiki.chenxun.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class FileBuffer<T> {

    private volatile  boolean isShutDown;

    /**
     * low memory
     */
    private final List<Object[]> bufferList;


    public  FileBuffer(int fileCount,int bufferSize){
        bufferList=new ArrayList<>();
        for(int i=0;i<fileCount;i++){
            bufferList.add(new Object[bufferSize]);
        }
    }





    public void push(List<T> dataList){
        for(T t:dataList){
            // 查询有空的buffer，如果没有则block 自旋


            // 写入buffer
        }
    }

    public void shutDown(){
        this.isShutDown=true;
    }


    public void start(ExecutorService executorService){
         // 一个excel 文件提交一个任务

        bufferList.forEach(i->{
            executorService.submit(()->{

                while (true){

                    // 判断buffer是否已经满
                    if(i[i.length-1]!=null || isShutDown){
                        // 写入excel

                        // 清理数据
                        Arrays.fill(i, null);

                        if(isShutDown){
                            break;
                        }
                    }
                }

            });

        });





    }



}
