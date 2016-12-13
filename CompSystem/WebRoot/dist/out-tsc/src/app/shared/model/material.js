export var Material = (function () {
    function Material() {
    }
    Material.prototype.MaterialId = function (materialId) {
        this.materialId = materialId;
        return this;
    };
    Material.prototype.Student = function (student) {
        this.student = student;
        return this;
    };
    Material.prototype.MaterialName = function (materialName) {
        this.materialName = materialName;
        return this;
    };
    Material.prototype.materialPic = function (materialPic) {
        this.materialPic = materialPic;
        return this;
    };
    return Material;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/material.js.map