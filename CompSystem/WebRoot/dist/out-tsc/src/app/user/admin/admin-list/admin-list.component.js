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
import { AdminService } from './../admin.service';
var AdminListComponent = (function () {
    function AdminListComponent(adminService) {
        this.adminService = adminService;
        this.admins = [];
        this.table = {
            admin: {
                loadingIndicator: false,
                columns: [
                    { prop: 'adminNo' },
                    { name: 'password' },
                    { name: 'adminName' },
                    { name: 'department' }
                ]
            }
        };
        this.getAdmins();
    }
    AdminListComponent.prototype.ngOnInit = function () {
    };
    AdminListComponent.prototype.getAdmins = function () {
        var _this = this;
        this.adminService.getAdmins()
            .then(function (admins) { return _this.admins = admins; }, function (error) { return _this.errorMessage = error; });
    };
    return AdminListComponent;
}());
AdminListComponent = __decorate([
    Component({
        selector: 'app-admin-list',
        templateUrl: './admin-list.component.html',
        styleUrls: ['./admin-list.component.css'],
        providers: [AdminService]
    }),
    __metadata("design:paramtypes", [AdminService])
], AdminListComponent);
export { AdminListComponent };
//# sourceMappingURL=../../../../../../../src/app/user/admin/admin-list/admin-list.component.js.map