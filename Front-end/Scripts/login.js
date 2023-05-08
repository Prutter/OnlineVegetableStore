let submitbtn= document.querySelector(".form>form");

submitbtn.onsubmit= (e)=>{
    e.preventDefault();
    let username= document.querySelector("#username").value;
    let password= document.querySelector("#password").value;
    let obj = JSON.parse(localStorage.getItem("customer"));
    console.log(obj);
    if(obj.userName === username && password===obj.password)
       {
        
        
        alert("login successful");
        window.location.href="index.html"
       }
        else 
          {
            alert("Credential Invalid");
          }

    

    // let url= "http://localhost:8088/organicoasis/Login";
    // loginuser(url,obj);

};


let loginuser= async (url,obj)=>{
    try {
        let res= await fetch(url,{
            method:"POST",
            headers:{
               "Content-Type":"application/json"
            },
            body:JSON.stringify(obj)
        });
          console.log(res);
        if(res.ok)
         {
             let ans= await res.json();
             console.log(ans);
             alert(ans);    
         }
          else 
           {
            console.log("else part");
                let error= await res.json();
                alert(error.message);
                console.log(error);
           }
    } catch (error) {
        alert(error);
    }
    
};