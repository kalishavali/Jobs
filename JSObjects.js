var data = {
    	"First":{
            "Red":"Pass",
            "Amber":"Pass",
        },
        "Second":{
        	"Red":"Pass",
            "Amber":"Pass",
        },
        "Third":{
        	"Red":"Pass",
           "Amber":"Pass",
        }
    };
    var failStatus=false;
    var needStatus=false;
    var obj = data.First;
    for (var o in obj){
      if(o=="Red" && obj[o]=="Fail"){
      	failStatus=true;
      }else if(o=="Red" && obj[o]=="NeedAttention"){
      	needStatus=true;
      }else if(o=="Amber" && obj[o]=="Fail"){
      	needStatus=true;
      }else if(o=="Amber" && obj[o]=="NeedAttention"){
      	needStatus=true;
      }
    }
    var obj = data.Third;
    for (var o in obj){
      if(o=="Red" && obj[o]=="Fail"){
      	failStatus=true;
      }else if(o=="Red" && obj[o]=="NeedAttention"){
      	needStatus=true;
      }else if(o=="Amber" && obj[o]=="Fail"){
      	needStatus=true;
      }else if(o=="Amber" && obj[o]=="NeedAttention"){
      	needStatus=true;
      }
    }
    var obj = data.Second;
    for (var o in obj){
      if(o=="Red" && obj[o]=="Fail"){
      	failStatus=true;
      }else if(o=="Red" && obj[o]=="NeedAttention"){
      	needStatus=true;
      }else if(o=="Amber" && obj[o]=="Fail"){
      	needStatus=true;
      }else if(o=="Amber" && obj[o]=="NeedAttention"){
      	needStatus=true;
      }
    }
    var result="";
    if(failStatus){
    	result="Don't proceed";
    }else if(needStatus){
    	result="Proceed with Caution";
    }else{
    	result="Good to Go";
    }
    document.body.innerHTML ="<b>"+result+"</b>";
    // Object.keys(str.First).length
