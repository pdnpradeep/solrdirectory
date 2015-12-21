/**
 * Created by Pradeep.P on 16-10-2015.
 */
define(["models/contactsmodel","views/contactsview","views/newcontactview"],function(contactsmodel,contactsview,newcontactview){
    var AppRouter = Backbone.Router.extend({
        initialize : function(options){
            this.notes = options.notes;
           // alert("router is initialized"+this.notes);

        },
        routes: {
            "index": "index",
            "note/new": "create",
            "first": "first"
        },
        first:function(){
            window.location.hash = "index";
        },
        index:function(){
            this.contactsview1 = new contactsview({notes: this.notes});
            $('#maincontainer').html(this.contactsview1.render().el);
            console.log(this.contactsview1);
        },
        create:function(){
            this.currentView = new newcontactview({
                notes: this.notes, note: new contactsmodel()
            });

            $('#maincontainer').html(this.currentView.render().el);
        }
    });
    return AppRouter;
});