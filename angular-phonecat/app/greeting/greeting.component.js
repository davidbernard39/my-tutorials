'use strict';

angular.module('phonecatApp').
component('greetUser', {
    template: 'Hello, {{$ctrl.user}} !',
    controller: function GreetUserController() {
        this.user = 'Toto';
    }
});
