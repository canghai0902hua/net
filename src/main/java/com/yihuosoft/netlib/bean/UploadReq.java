package com.yihuosoft.netlib.bean;

import java.io.Serializable;

public class UploadReq implements Serializable {
    private int      fileSize;
    private int   fileType;
    private int  isMedia;
    private int   isWatermark;
    private String   md5;
    private String   originFileName;
    private int   tenantId;
    private String   watermarkContent;

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public int getIsMedia() {
        return isMedia;
    }

    public void setIsMedia(int isMedia) {
        this.isMedia = isMedia;
    }

    public int getIsWatermark() {
        return isWatermark;
    }

    public void setIsWatermark(int isWatermark) {
        this.isWatermark = isWatermark;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getWatermarkContent() {
        return watermarkContent;
    }

    public void setWatermarkContent(String watermarkContent) {
        this.watermarkContent = watermarkContent;
    }

    @Override
    public String toString() {
        return "UploadReq{" +
                "fileSize=" + fileSize +
                ", fileType=" + fileType +
                ", isMedia=" + isMedia +
                ", isWatermark=" + isWatermark +
                ", md5='" + md5 + '\'' +
                ", originFileName='" + originFileName + '\'' +
                ", tenantId=" + tenantId +
                ", watermarkContent='" + watermarkContent + '\'' +
                '}';
    }
}
