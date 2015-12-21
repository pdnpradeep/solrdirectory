/**
 * Created by Pradeep.P on 16-10-2015.
 */
require(["router/router","collections/collectioncm"],function(router,collectioncm){
         this.collection1 = new collectioncm;
        this.collection1.fetch({
            success : function(collection, response) {
                // code here
               // alert("success"+JSON.stringify(collection1));
                this.router1 = new router({notes:collection1});
                Backbone.history.start();
                console.log(this.router1);
                window.location.hash = "index";
            },

            error : function(collection, response) {
                // code here
                alert("error");
            }
        });
    }

);