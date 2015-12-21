/**
 * Created by Pradeep.P on 20-10-2015.
 */
define(["jquery",
    "underscore",
    "backbone",
],function($,_,Backbone){
    var newcontactview = Backbone.View.extend({
        events: {
            "click button.save": "save"
        },
        initialize:function(options){
           // alert("its in the initialize of newcontactview");
            this.note  = options.note;
            this.notes = options.notes;
        },
        render: function (){
            //alert("its in the render of newcontactview");
             this.newcontactviewtemplate = "<div class=\"well\">\n" +
                "      <div class=\"alert alert-danger fade in\" style=\"display:none;\"></div>\n" +
                "      <form>\n" +
                "        <h2><%= firstName %></h2>\n" +
                "        <div class=\"form-group\">\n" +
                "          <label>First Name:</label>\n" +
                "          <input type=\"text\" class=\"form-control\" name=\"firstName\" value=\"<%= firstName %>\" />\n" +
                 "        </div>\n" +
                "        <div class=\"form-group\">\n" +
                "          <label>Last Name:</label>\n" +
                "          <input type=\"text\" class=\"form-control\" name=\"lastName\" value=\"<%= lastName %>\" />\n" +
                "        </div>\n" +
                "        <div class=\"form-group\">\n" +
                "          <label>Phone Number:</label>\n" +
                "          <input type=\"number\" class=\"form-control\" rows=\"1\" max=\"9999999999\" min=\"1000000000\" name=\"phoneNo\" value=\"<%= phoneNo %>\" />\n" +
                "        </div>\n" +
                "        <button class=\"save btn btn-large btn-info\" type=\"submit\">Save</button>\n" +
                "        <a href=\"#/index\" class=\"btn btn-large\">Cancel</a>\n" +
                "      </form>\n" +
                "    </div>";
            this.$el.html(_.template( this.newcontactviewtemplate)(this.note.toJSON()));
            return this;
        },
        save: function (event) {
            event.stopPropagation();
            event.preventDefault();

            this.note.set({
                firstName: this.$el.find('input[name=firstName]').val(),
                lastName: this.$el.find('input[name=lastName]').val(),
                phoneNo: parseInt(this.$el.find('input[name=phoneNo]').val()),
            });


           // this.notes.create(this.note);
           /* if (this.note.isValid()){*/
                //this.note.save();
            this.note.save(null, {
                success: function (note, response) {
                    console.log("success");
                    this.notes.add(this.note);
                    window.location.hash = "index";
                },
                error: function (note, response) {
                    console.log("error");
                }
            });
                // add it to the collection
               // this.notes.add(this.note);
                // this.note.save();
                // redirect back to the index
               // window.location.hash = "notes/index";
           /* }*/
        },
    });
    return newcontactview;
});
