<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<style>
#container {
	border: 2px solid black;
	min-width: 310px;
	max-width: 800px;
	height: 400px;
	margin: 10px auto
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solar Employment Growth by Sector</title>
</head>
<body>
	<div id="container"></div>
	<script>
Highcharts.chart('container', {

    title: {
        text: 'Solar Employment Growth '
    },

    subtitle: {
        text: 'Source: thesolarfoundation.com'
    },
    xAxis: {
        title: {
            text: 'Year'
        }
    },

    yAxis: {
        title: {
            text: 'Number of Employees in 000s'
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle'
    },

    plotOptions: {
        series: {
        	pointStart: 2000
        }
    },

    series: [{
        name: 'Installation',
        data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
    }, {
        name: 'Manufacturing',
        data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
    }]
});
</script>
</body>
</html>