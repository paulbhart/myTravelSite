<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script
		src="http://ajax.cdnjs.com/ajax/libs/underscore.js/1.3.3/underscore-min.js"></script>
	<script
		src="http://ajax.cdnjs.com/ajax/libs/backbone.js/0.9.2/backbone-min.js"></script>

	<!-- Template of the Tweets View -->
	<!-- Template of the Tweets View -->
	<script>
	_.templateSettings = {
    interpolate: /\<\@\=(.+?)\@\>/gim,
    evaluate: /\<\@(.+?)\@\>/gim
};
	</script>
	<script type="text/template" id="tweetsTemplate">
    <@ _.each(tweets, function (tweet) { @>
    <div class="tweet">
        <p><@= tweet.Name @></p>
        <p class="text"><@= tweet.text @></p><p><@= tweet.location @></p>
    </div>
    <@ }); @>
	</script>
	<script type="text/javascript">
		// Define the model
		Tweet = Backbone.Model.extend();

		// Define the collection
		Tweets = Backbone.Collection
				.extend({
					model : Tweet,
					// Url to request when fetch() is called
					//http://search.twitter.com/search.json?q=Hamburg&rpp=5&lang=allurl : 'http://search.twitter.com/search.json?q=Hamburg&rpp=5&lang=all',
					url : 'http://localhost:8080/myTravelSite/Hotel/1',
					parse : function(response) {
						return response;
					},
					// Overwrite the sync method to pass over the Same Origin Policy
					sync : function(method, model, options) {
						var that = this;
						var params = _.extend({
							type : 'GET',
							dataType : 'jsonp',
							url : that.url,
							processData : false
						}, options);

						return $.ajax(params);
					}
				});

		// Define the View
		TweetsView = Backbone.View.extend({
			initialize : function() {
				_.bindAll(this, 'render');
				// create a collection
				this.collection = new Tweets;
				// Fetch the collection and call render() method
				var that = this;
				this.collection.fetch({
					success : function(model, response) {
						that.render();
						myModel = model;
						myResponse = response;
					},
					failure : function(model, response) {
						myModel = model;
						myResponse = response;
					}	
				});
			},
			// Use an extern template
			template : _.template($('#tweetsTemplate').html()),

			render : function() {
				// Fill the html with the template and the collection
				$(this.el).html(this.template({
					tweets : this.collection.toJSON()
				}));
				myCollection = this.collection.toJSON();
				myCollection = this.collection.toJSON();
			}
		});

		var app = new TweetsView({
			// define the el where the view will render
			el : $('body')
		});
	</script>
</body>
</html>