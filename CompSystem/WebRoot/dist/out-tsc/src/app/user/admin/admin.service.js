var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
var AdminService = (function () {
    function AdminService(http) {
        this.http = http;
        this.adminsUrl = 'app/user/admin/shared/admins.json';
    }
    AdminService.prototype.getAdmins = function () {
        return this.http.get(this.adminsUrl)
            .toPromise()
            .then(this.extractData)
            .catch(this.handleError);
    };
    AdminService.prototype.extractData = function (res) {
        var body = res.json();
        return body.data || {};
    };
    AdminService.prototype.handleError = function (error) {
        var errMsg;
        if (error instanceof Response) {
            var body = error.json() || '';
            var err = body.error || JSON.stringify(body);
            errMsg = error.status + " - " + (error.statusText || '') + " " + err;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Promise.reject(errMsg);
    };
    return AdminService;
}());
AdminService = __decorate([
    Injectable(),
    __metadata("design:paramtypes", [Http])
], AdminService);
export { AdminService };
//# sourceMappingURL=../../../../../../src/app/user/admin/admin.service.js.map