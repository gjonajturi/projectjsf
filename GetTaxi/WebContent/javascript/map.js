
  var map;
 var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var start=new google.maps.LatLng(41.431752,19.710803);
var end;
  function calcRoute(e) {
	  end=e;
	  var request = {
	      origin: start,
	      destination: end,
	      travelMode: google.maps.TravelMode.DRIVING
	  };
	  // cohet kerkesa dhe rezultati shtohet ne harte 
	  directionsService.route(request, function(response, status) {
	    if (status == google.maps.DirectionsStatus.OK) {
	      directionsDisplay.setDirections(response);
	    }
	  });
	}
 
function initialize(){
	directionsDisplay= new google.maps.DirectionsRenderer();
var myOptions =
{
zoom: 14,
center: new google.maps.LatLng(41.328071,19.818628),
mapTypeId: google.maps.MapTypeId.ROADMAP
}
map = new google.maps.Map(document.getElementById("map"), myOptions);
directionsDisplay.setMap(map);
map.addListener('click',function(event){
	calcRoute(event.latLng);
	getVars(event.latLng);
});
}
function getVars(latlng) {
    // ...
    var startlat =start.lat() ;
    var startlng = start.lng();
    var endlat=latlng.lat();
    var endlng=latlng.lng();
 
    document.getElementById("formId:startlat").value = startlat;
    document.getElementById("formId:startlng").value = startlng;
    document.getElementById("formId:endlat").value=endlat;
    document.getElementById("formId:endlng").value=endlng;
} 
