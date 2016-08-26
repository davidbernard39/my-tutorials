'use strict';

describe('phoneList', function () {
   
    // Load the module that contains the phone list before each test
    beforeEach(module('phoneList'));
    
    describe('PhoneListController', function () {
         
        it('should create a `phones` model with 3 phones', inject(function ($componentController) {
            var ctrl = $componentController('phoneList');
        
            expect(ctrl.phones.length).toBe(3);
        }));

    });
});