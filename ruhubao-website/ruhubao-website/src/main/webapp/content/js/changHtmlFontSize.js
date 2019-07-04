function changFontSize(){
		var maxWidth = 750;
		var htmlFontsize = 100;
		var standardSize = 750;
		
		window.onresize = setFontSize; //屏膜改变改变字体大小
		
		setFontSize(); //运行设置字体大小函数
		
		function setFontSize() {
			var windowInnerWidth = window.innerWidth;
			windowInnerWidth = (windowInnerWidth > maxWidth) ? maxWidth : windowInnerWidth;
			document.documentElement.style.fontSize = ((windowInnerWidth / standardSize) * htmlFontsize) + 'px';
		}
}

changFontSize()