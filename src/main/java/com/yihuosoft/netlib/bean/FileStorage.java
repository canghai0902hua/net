package com.yihuosoft.netlib.bean;

import java.io.Serializable;
import java.util.List;

public class FileStorage implements Serializable {
  private int        beforeStatus;
  private String     createBy;
    private String   createTime;
    private String   fileDescription;
    private String   fileFormat;
    private String   fileName;
    private long      fileSize;
    private String   fileSource;
    private int      fileType;
    private List<FileUrl> fileUrls;
    private int    groupId;
    private int    id;
    private int    isBlackAndWhite;
    private int    isMedia;
    private int    isWatermark;
    private String md5;
    private String picUrl;
    private String remarks;
    private int    status;
    private int    storageType;
    private int    tenantId;
    private String updateBy;
    private String updateTime;
    private String watermarkContent;
    private Group group;

    public int getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(int beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public List<FileUrl> getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(List<FileUrl> fileUrls) {
        this.fileUrls = fileUrls;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsBlackAndWhite() {
        return isBlackAndWhite;
    }

    public void setIsBlackAndWhite(int isBlackAndWhite) {
        this.isBlackAndWhite = isBlackAndWhite;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWatermarkContent() {
        return watermarkContent;
    }

    public void setWatermarkContent(String watermarkContent) {
        this.watermarkContent = watermarkContent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "FileStorage{" +
                "beforeStatus=" + beforeStatus +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", fileSource='" + fileSource + '\'' +
                ", fileType=" + fileType +
                ", fileUrls=" + fileUrls +
                ", groupId=" + groupId +
                ", id=" + id +
                ", isBlackAndWhite=" + isBlackAndWhite +
                ", isMedia=" + isMedia +
                ", isWatermark=" + isWatermark +
                ", md5='" + md5 + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", storageType=" + storageType +
                ", tenantId=" + tenantId +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", watermarkContent='" + watermarkContent + '\'' +
                ", group=" + group +
                '}';
    }

    public static class FileUrl implements Serializable {
        private int    fileId;
        private int    id;
        private int    isBlackAndWhite;
        private int    isWatermark;
        private int    level;
        private String url;

        public int getFileId() {
            return fileId;
        }

        public void setFileId(int fileId) {
            this.fileId = fileId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsBlackAndWhite() {
            return isBlackAndWhite;
        }

        public void setIsBlackAndWhite(int isBlackAndWhite) {
            this.isBlackAndWhite = isBlackAndWhite;
        }

        public int getIsWatermark() {
            return isWatermark;
        }

        public void setIsWatermark(int isWatermark) {
            this.isWatermark = isWatermark;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "FileUrl{" +
                    "fileId=" + fileId +
                    ", id=" + id +
                    ", isBlackAndWhite=" + isBlackAndWhite +
                    ", isWatermark=" + isWatermark +
                    ", level=" + level +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public class Group{
        private String  groupName;
        private int     id;
        private int     orderNo;
        private int     tenantId;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

        public int getTenantId() {
            return tenantId;
        }

        public void setTenantId(int tenantId) {
            this.tenantId = tenantId;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "groupName='" + groupName + '\'' +
                    ", id=" + id +
                    ", orderNo=" + orderNo +
                    ", tenantId=" + tenantId +
                    '}';
        }
    }
}
