<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<!--Step:2 Prepare a dom for ECharts which (must) has size (width & hight)-->
	<!--Step:2 为ECharts准备一个具备大小（宽高）的Dom-->
	<div id="mainMap" style="height: 500px; border: 1px solid #ccc; padding: 10px;"></div>
</body>
<!--Step:1 Import echarts-plain.js or echarts-plain-map.js-->
<!--Step:1 引入echarts-plain.js或者 echarts-plain-map.js-->
<script src="echarts-plain-map.js"></script>
<script src="static.js"></script>
<script type="text/javascript">
	// Step:3 echarts & zrender as a Global Interface by the echarts-plain.js.
	// Step:3 echarts和zrender被echarts-plain.js写入为全局接口
	// --- 地图 ---
	var mapChart = echarts.init(document.getElementById('mainMap'));
	var curIndx = 0;
	var mapType =
	[
			'china',
			// 23个省
			'广东', '青海', '四川', '海南', '陕西', '甘肃', '云南', '湖南', '湖北', '黑龙江', '贵州', '山东', '江西', '河南', '河北', '山西', '安徽', '福建', '浙江', '江苏', '吉林', '辽宁', '台湾',
			// 5个自治区
			'新疆', '广西', '宁夏', '内蒙古', '西藏',
			// 4个直辖市
			'北京', '天津', '上海', '重庆',
			// 2个特别行政区
			'香港', '澳门'
	];
	option =
	{
		title :
		{
			text : '全国34个省市自治区',
			subtext : 'china （滚轮或点击切换）'
		},
		tooltip :
		{
			trigger : 'item',
			formatter : '滚轮切换或点击进入该省<br/>{b}'
		},
		legend :
		{
			orient : 'vertical',
			x : 'right',
			data :
			[
				'随机数据'
			]
		},
		dataRange :
		{
			min : 0,
			max : 1000,
			color :
			[
					'black', 'red'
			],
			text :
			[
					'高', '低'
			], // 文本，默认为数值文本
			calculable : true
		},
		series :
		[
			{
				name : '随机数据',
				type : 'map',
				mapType : 'china|四川',
				selectedMode : 'single',
				itemStyle :
				{
					normal :
					{
						label :
						{
							show : true
						}
					},
					emphasis :
					{
						label :
						{
							show : true
						}
					}
				},
				data : myData
			}
		]
	};
	mapChart.setOption(option, true);
	
	document.getElementById('mainMap').onmousewheel = function(e)
	{
		var event = e || window.event;
		// 			curIndx += zrEvent.getDelta(event) > 0 ? (-1) : 1;
		curIndx += zrender.tool.event.getDelta(event) > 0 ? (-1) : 1;
		if (curIndx < 0)
		{
			curIndx = mapType.length - 1;
		}
		var mt = mapType[curIndx % mapType.length];
		if (mt == 'china')
		{
			option.tooltip.formatter = '滚轮切换或点击进入该省<br/>{b}';
		}
		else
		{
			option.tooltip.formatter = '滚轮切换省份或点击返回全国<br/>{b}';
		}
		option.series[0].mapType = mt;
		option.title.subtext = mt + ' （滚轮或点击切换）';
		mapChart.setOption(option, true);

		// 			zrEvent.stop(event);
		zrender.tool.event.stop(event);
	};
	// 		mapChart.on(ecConfig.EVENT.MAP_SELECTED, function(param)
	mapChart.on(echarts.config.EVENT.MAP_SELECTED, function(param)
	{
		var len = mapType.length;
		var mt = mapType[curIndx % len];
		if (mt == 'china')
		{
			// 全国选择时指定到选中的省份
			var selected = param.selected;
			for ( var i in selected)
			{
				if (selected[i])
				{
					mt = i;
					while (len--)
					{
						if (mapType[len] == mt)
						{
							curIndx = len;
						}
					}
					break;
				}
			}
			option.tooltip.formatter = '滚轮切换省份或点击返回全国<br/>{b}';
		}
		else
		{
			curIndx = 0;
			mt = 'china';
			option.tooltip.formatter = '滚轮切换或点击进入该省<br/>{b}';
		}
		option.series[0].mapType = mt;
		option.title.subtext = mt + ' （滚轮或点击切换）';
		mapChart.setOption(option, true);
	});
</script>
</html>