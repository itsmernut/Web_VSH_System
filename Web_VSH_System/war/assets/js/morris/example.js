$(function () {
  eval($('#code').text());
  prettyPrint();
  Morris.Donut({
  element: 'graph',
  data: [
    {value: 56, label: 'Visited'},
    {value: 44, label: 'Not visit'},
  ],
backgroundColor: '#ccc',
  labelColor: '#525252',
  colors: [
    '#5EB460',
    '#C12E2E'
  ],
  formatter: function (x) { return x + "%"}
});
});

$(function () {
  eval($('#code').text());
  prettyPrint();
  /* data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type */
var day_data = [
  {"period": "M.1", "licensed": 246},
  {"period": "M.2", "licensed": 452},
  {"period": "M.3", "licensed": 139},
  {"period": "M.4", "licensed": 268},
  {"period": "M.5", "licensed": 634},
  {"period": "M.6", "licensed": 320},
];
Morris.Bar({
  element: 'graph2',
  data: day_data,
  xkey: 'period',
  ykeys: ['licensed'],
  labels: ['Licensed'],
  xLabelAngle: 60
});
});