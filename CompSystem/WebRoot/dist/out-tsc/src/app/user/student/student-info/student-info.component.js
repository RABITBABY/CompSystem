var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
var StudentInfoComponent = (function () {
    function StudentInfoComponent() {
        this.studentInfo = {
            sno: "学号",
            name: "姓名",
            gender: "性别",
            department: "学院(系)",
            profession: "专业",
            classno: "班别",
            grade: "年级",
            phone: "手机号",
            email: "邮箱",
        };
        this.disableEdit = true;
    }
    StudentInfoComponent.prototype.ngOnInit = function () {
    };
    StudentInfoComponent.prototype.toggleEdit = function () {
        this.disableEdit = !this.disableEdit;
    };
    return StudentInfoComponent;
}());
StudentInfoComponent = __decorate([
    Component({
        selector: 'app-student-info',
        templateUrl: './student-info.component.html',
        styleUrls: ['./student-info.component.css']
    }),
    __metadata("design:paramtypes", [])
], StudentInfoComponent);
export { StudentInfoComponent };
//# sourceMappingURL=../../../../../../../src/app/user/student/student-info/student-info.component.js.map