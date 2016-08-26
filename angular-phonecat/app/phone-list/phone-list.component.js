'use strict';

// Register components to the module
angular.
module('phoneList').
component('phoneList', {
    templateUrl: 'phone-list/phone-list.template.html',
    controller: function PhoneListController() {
        this.phones = [
            {
                name: 'Nexus S',
                snippet: 'Super rapide',
                age: 1
                }, {
                name: 'Motorolla XOOM avec Wi-Fi',
                snippet: 'La prochaine génération de tablette',
                age: 1
                }, {
                name: 'Motorolla XOOM',
                snippet: 'La prochaine génération de tablette',
                age: 1
                }
            ];
        this.orderProp = 'age';
    }
});
