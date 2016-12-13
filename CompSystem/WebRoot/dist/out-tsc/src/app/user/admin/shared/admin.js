export var Admin = (function () {
    function Admin() {
    }
    Admin.prototype.AdminNo = function (adminNo) {
        this.adminNo = adminNo;
        return this;
    };
    Admin.prototype.Password = function (password) {
        this.password = password;
        return this;
    };
    Admin.prototype.AdminName = function (adminName) {
        this.adminName = adminName;
        return this;
    };
    Admin.prototype.Department = function (department) {
        this.department = department;
        return this;
    };
    return Admin;
}());
//# sourceMappingURL=../../../../../../../src/app/user/admin/shared/admin.js.map