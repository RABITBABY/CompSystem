export var Department = (function () {
    function Department() {
    }
    Department.prototype.DepartmentId = function (departmentId) {
        this.departmentId = departmentId;
        return this;
    };
    Department.prototype.DepartmentName = function (departmentName) {
        this.departmentName = departmentName;
        return this;
    };
    return Department;
}());
//# sourceMappingURL=../../../../../../src/app/contest/shared/department.js.map