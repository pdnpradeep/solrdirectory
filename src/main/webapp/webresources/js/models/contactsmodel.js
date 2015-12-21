/**
 * Created by Pradeep.P on 16-10-2015.
 */
define(["jquery","underscore","backbone"],function($,_,Backbone){

    var contactsmodel = Backbone.Model.extend({

        defaults: {
            firstName: "",
            phoneNo: "",
            lastName: ""
        }
    });
    return contactsmodel;
});