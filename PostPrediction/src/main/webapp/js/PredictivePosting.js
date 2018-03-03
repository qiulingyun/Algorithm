/**
 * 
 */

var tabs = null;
//var contents = document.getElementsByClassName('tab-content')[0].getElementsByTagName('div');

window.onload = function(){
	changeTab();
}
function changeTab() {
	tabs = document.getElementById('choice').getElementsByTagName('th');
	for (var i = 0, len = tabs.length; i < len; i++) {
		tabs[i].onmouseover = showTab;
	}
};

function showTab() {
	for (var i = 0, len = tabs.length; i < len; i++) {
		if (tabs[i] === this) {
			tabs[i].className = 'choice_td_selected';
//			contents[i].className = 'show';
		} else {
			tabs[i].className = 'choice_td';
//			contents[i].className = '';
		}
	}
}