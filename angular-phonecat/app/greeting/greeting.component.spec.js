'use strict';

describe('greetUser', function () {
   
    // Load the module that contains the phone list before each test
    beforeEach(module('phonecatApp'));
    
    describe('GreetUserController', function () {
         
        it('should name world as user', inject(function ($componentController) {
            var ctrl = $componentController('greetUser');
        
            expect(ctrl.user).toBe('Toto');
        }));

    });
});