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
import { AppService } from './../../app.service';
var ContestListComponent = (function () {
    function ContestListComponent(appService) {
        this.appService = appService;
        this.title = 'contest titile';
    }
    ContestListComponent.prototype.getContests = function () {
    };
    ContestListComponent.prototype.ngOnInit = function () {
        this.getContests();
    };
    return ContestListComponent;
}());
ContestListComponent = __decorate([
    Component({
        selector: 'app-contest-list',
        templateUrl: './contest-list.component.html',
        styleUrls: ['./contest-list.component.css'],
        providers: [AppService]
    }),
    __metadata("design:paramtypes", [AppService])
], ContestListComponent);
export { ContestListComponent };
//# sourceMappingURL=../../../../../../src/app/contest/contest-list/contest-list.component.js.map