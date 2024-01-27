package com.yihuosoft.netlib.bean;

//获取真实的文件上传地址
public class UploadRealAddress extends BaseResponse<UploadRealAddress.Result> {
    public static class Result {
        private String realOperationUrl;
        private String fileUrl;
        private String existFileId;
        private int fileType;
        private String fileFormat;
        private String contentType;
        private int strategyType;
        private String sign_key;
        private WatermarkHeader watermarkHeader;

        public String getRealOperationUrl() {
            return realOperationUrl;
        }

        public void setRealOperationUrl(String realOperationUrl) {
            this.realOperationUrl = realOperationUrl;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getExistFileId() {
            return existFileId;
        }

        public void setExistFileId(String existFileId) {
            this.existFileId = existFileId;
        }

        public int getFileType() {
            return fileType;
        }

        public void setFileType(int fileType) {
            this.fileType = fileType;
        }

        public String getFileFormat() {
            return fileFormat;
        }

        public void setFileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public int getStrategyType() {
            return strategyType;
        }

        public void setStrategyType(int strategyType) {
            this.strategyType = strategyType;
        }

        public String getSign_key() {
            return sign_key;
        }

        public void setSign_key(String sign_key) {
            this.sign_key = sign_key;
        }

        public WatermarkHeader getWatermarkHeader() {
            return watermarkHeader;
        }

        public void setWatermarkHeader(WatermarkHeader watermarkHeader) {
            this.watermarkHeader = watermarkHeader;
        }

        public class WatermarkHeader {

        }

        @Override
        public String toString() {
            return "Result{" +
                    "realOperationUrl='" + realOperationUrl + '\'' +
                    ", fileUrl='" + fileUrl + '\'' +
                    ", existFileId=" + existFileId +
                    ", fileType=" + fileType +
                    ", fileFormat='" + fileFormat + '\'' +
                    ", contentType='" + contentType + '\'' +
                    ", strategyType=" + strategyType +
                    ", sign_key='" + sign_key + '\'' +
                    ", watermarkHeader=" + watermarkHeader +
                    '}';
        }
    }
}
