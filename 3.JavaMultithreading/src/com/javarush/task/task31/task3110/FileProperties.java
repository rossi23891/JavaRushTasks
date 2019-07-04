package com.javarush.task.task31.task3110;

public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public long getCompressionRatio(){
        return  100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        String output = null;
        if(getSize()>0){
            output= getName() + " " + getSize()/1024 + " Kb (" + getCompressedSize()/1024 + " Kb) сжатие: "  + getCompressionRatio() + "%";
        }else{
           output=getName();
        }

        return output;
    }

}
