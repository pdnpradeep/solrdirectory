/**
 * Created by Pradeep.P on 20-10-2015.
 */
define(["jquery",
    "underscore",
    "backbone",
],function($,_,Backbone){
    var noterowview = Backbone.View.extend({
        tagName: "tr",
        initialize: function (options) {
            // model is passed through
           // alert("this is noterowview"+options.note);
            this.note  = options.note;
            this.notes = options.notes;
        },
        render:function(){
           // alert("this is in noterowview on render");
            this.rowTemplate = "<td>\n" +
                " <a href=\"#note/<%= phoneNo %>/view\"><%= firstName %></a>\n" +
                "</td>\n" +
                "<td><%= lastName %></td>\n" +
                "<td><%= phoneNo %></td>\n" +
                "<td>\n" +
                " <a href=\"#\" class=\"delete btn btn-danger btn-small\">delete</a>\n" +
                "</td>";
            this.$el.html(_.template(this.rowTemplate)(this.note.toJSON()));
            return this;
        }
    });
    return noterowview;
});