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
var AdminComponent = (function () {
    function AdminComponent() {
        this.links = [
            {
                href: '/admin',
                name: '仪表板'
            },
            {
                href: 'article',
                name: '文章模块'
            },
            {
                href: 'adminList',
                name: '管理员列表'
            }
        ];
    }
    AdminComponent.prototype.ngOnInit = function () {
    };
    return AdminComponent;
}());
AdminComponent = __decorate([
    Component({
        selector: 'app-admin',
        templateUrl: './admin.component.html',
        styleUrls: ['./admin.component.css']
    }),
    __metadata("design:paramtypes", [])
], AdminComponent);
export { AdminComponent };
//# sourceMappingURL=../../../../../../src/app/user/admin/admin.component.js.map