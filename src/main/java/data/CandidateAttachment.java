package data;

public class CandidateAttachment {

    private String fileName;
    private String fileType;

    public void setFileName(Object fileName) {
        if (fileName == null) {
            this.fileName = "";
        } else {
            this.fileName = fileName.toString();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileType(Object fileType) {
        if (fileType == null) {
            this.fileType = "";
        } else {
            this.fileType = fileType.toString();
        }
    }

    public String getFileType() {
        return fileType;
    }
}
