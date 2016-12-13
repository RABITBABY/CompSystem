export var Student = (function () {
    function Student() {
    }
    Student.prototype.StudentNo = function (studentNo) {
        this.studentNo = studentNo;
        return this;
    };
    Student.prototype.StudentName = function (studentName) {
        this.studentName = studentName;
        return this;
    };
    Student.prototype.Gender = function (gender) {
        this.gender = gender;
        return this;
    };
    Student.prototype.Department = function (department) {
        this.department = department;
        return this;
    };
    Student.prototype.Profession = function (profession) {
        this.profession = profession;
        return this;
    };
    Student.prototype.Classno = function (classno) {
        this.classno = classno;
        return this;
    };
    Student.prototype.Grade = function (grade) {
        this.grade = grade;
        return this;
    };
    Student.prototype.Phone = function (phone) {
        this.phone = phone;
        return this;
    };
    Student.prototype.Email = function (email) {
        this.email = email;
        return this;
    };
    Student.prototype.Password = function (password) {
        this.password = password;
        return this;
    };
    Student.prototype.GroupsDetails = function (groupsDetails) {
        this.groupsDetails = groupsDetails;
        return this;
    };
    return Student;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/student.js.map