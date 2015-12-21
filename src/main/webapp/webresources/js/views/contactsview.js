/**
 * Created by Pradeep.P on 16-10-2015.
 */
define(["jquery",
    "underscore",
    "backbone",
    "models/contactsmodel",
    "views/noterowview"
   /* "text!"+"templates/noteindex.html"*/
],function($,_,Backbone,contactsmodel,noterowview){

        var contentsview = Backbone.View.extend({
            // the constructor
            initialize: function (options) {
               // alert("this is contentsview");
                // model is passed through
                this.notes = options.notes;
                this.notes.bind('reset', this.addAll, this);

            },
            events:{
                'keypress .form-control' : 'searchData'
            },

            // populate the html to the dom
            render: function () {
                noteindex =   "<div><div class=\"well\"><a class=\"btn btn-block btn-large btn-info\" href=\"#note/new\">Add New Phone Number</a></div> <input class=\"form-control\" id=\"inputdefault\" type=\"text\"/><table class=\"table table-striped\"><thead><tr><th width=\"20%\">F.Name</th><th width=\"20%\">L.Name</th><th>Phone Number</th><th></th></tr></thead><tbody></tbody></table></div>";
                this.$el.html(noteindex);
                this.addAll();
                return this;
            },

            addAll: function () {
                // clear out the container each time you render index
                this.$el.find('tbody').children().remove();
                _.each(this.notes.models, $.proxy(this, 'addOne'));
            },

            addOne: function (note) {
                this.view = new noterowview({
                    notes: this.notes,
                    note: note
                });
                this.$el.find("tbody").append(this.view.render().el);
            },
            searchData:function(e){
                if(e.keyCode == 13){
                    self = this;
                    $.ajax({
                        type: 'POST',
                        url: "/solrsearch.html",
                        data: {
                            term: e.target.value
                        },
                        error: function () {
                            alert("Search Failed");
                        },
                        success: function (htmlData) {
                            self.notes.set(JSON.parse(htmlData));
                            window.location.hash = "first";
                        }});
                }
            }


    });
        return contentsview;
    });