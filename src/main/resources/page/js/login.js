$(function() {
	//获取当前时间
	getCurrTime();
})


//获取当前时间
function getCurrTime() {
	var date = new Date();
	var month = date.getMonth(); //获取当前月份(0-11,0代表1月);
	var monthString = "January";
	switch (month) {
		case 0:
			monthString = "January";//一月
			break;
		case 1:
			monthString = "February";//二月
			 break;
		case 2:
			monthString = "March";//三月
			 break;
		case 3:
			monthString = "April";//四月
			 break;
		case 4:
			monthString = "May";//五月
			 break;
		case 5:
			monthString = "June";//六月
			 break;
		case 6:
			monthString = "July";//七月
			break;
		case 7:
			monthString = "August";//八月
			break;
		case 8:
			monthString = "September";//九月
			 break;
		case 9:
			monthString = "October";//十月
			 break;
		case 10:
			monthString = "November";//十一月
			 break;
		case 11:
			monthString = "December";//十二月
			 break;
	}
	console.log("月份是："+monthString);
	$("#monthspan").text(monthString+"		"+date.getDate());
}
