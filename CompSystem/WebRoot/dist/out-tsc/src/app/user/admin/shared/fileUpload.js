export var FileUpload = (function () {
    function FileUpload() {
    }
    FileUpload.prototype.FileId = function (fileId) {
        this.fileId = fileId;
        return this;
    };
    FileUpload.prototype.FileName = function (fileName) {
        this.fileName = fileName;
        return this;
    };
    FileUpload.prototype.SaveName = function (saveName) {
        this.saveName = saveName;
        return this;
    };
    FileUpload.prototype.UploadDate = function (uploadDate) {
        this.uploadDate = uploadDate;
        return this;
    };
    FileUpload.prototype.UploadUser = function (uploadUser) {
        this.uploadUser = uploadUser;
        return this;
    };
    return FileUpload;
}());
//# sourceMappingURL=../../../../../../../src/app/user/admin/shared/fileUpload.js.map