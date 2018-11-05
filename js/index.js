
$(function(){
				$(".list").hide();
			});


function liujian(obj){
	var id="#"+obj;
	var $myli=$(id);
	var info=($myli[0].style.display);

//alert(obj==box);
	if(info=="none"){
		$(id).show();
		
	}else{
		$(id).hide();
	}
}
	     
/*function liujian(obj){//把id传给方法  //这里让文字颜色渐变，不完美
	var box=document.getElementById(obj);//获取方法里的参数并传给box
	var box2=document.getElementById(obj).getElementsByTagName('li');
	var sum=1.0,sum2=0.1;
	var xs=document.getElementById('xs');
		if(box.style.height=='35%')
		{						 box.style.transition="1.75s";
			box.style.height="0px";	
			box.style.minHeight='0px';
				for(var i=0;i<box2.length;i++)
				{	
					for(var j=0;j<10;j++)
					{					
							if(sum==0.0)
							{
								sum=1.0;
							}
			
						sum=parseFloat((sum-sum2).toFixed(1));
						box2[i].style.opacity=sum;	
						box2[i].style.zIndex=-1;
					}
				}	
		}else{
	
		var sum3=0.0;
		box.style.height='35%';
		 box.style.transition=" 1.75s";
		for(var i=0;i<=box2.length;i++)
				{		
				for(var j=0;j<10;j++)
					{
					if(sum3==1.0)
					{
						sum3=0;	
					}	
							sum3=parseFloat((sum3+sum2).toFixed(1));//从0加到1，把值赋给sum
							box2[i].style.opacity=sum3;//把sum赋值给opacity属性
							box2[i].style.zIndex=1;
					 }
				 }
		  }
	}*/

/*function down_list(list){
	var Down_list=list.getElementsByTagName("ul")[0];//表示选中第一个div
	Down_list.style.display="block";		
	}
function out(list){
	var Down_list=list.getElementsByTagName("ul")[0];
		Down_list.style.display="none";
	}*/
/*function gundong()
{


var A=document.getElementById('head');
var scrollTop = document.documentElement.scrollTop||document.body.scrollTop||window.pageYOffset;
if(scrollTop>=100)
{
	//A.style.display="block"
	A.style.position="fixed"
	A.style.top="10px"
	A.style.zIndex="1"
	}
	else if(scrollTop<100)
	{
		A.style.position="inherit";
		}
		//document.getElementById('qw').innerHTML=document.body.scrollTop;

		setTimeout(gundong,1);
}*/