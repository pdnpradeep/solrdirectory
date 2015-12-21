/**
 * Created by Pradeep.P on 20-10-2015.
 */
define(["models/contactsmodel"],function(contactsmodel){
    var collectioncm = Backbone.Collection.extend({
        model: contactsmodel,
        url: '/allsolrdata.html'
    });
    return collectioncm;
});