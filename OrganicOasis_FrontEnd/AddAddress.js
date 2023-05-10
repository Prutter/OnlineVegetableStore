function registerAddress(){

    let flatno=document.getElementById("flatno").value;
    let building=document.getElementById("building").value;
    let area=document.getElementById("area").value;
    let city=document.getElementById("city").value;
    let Pincode=document.getElementById("Pincode").value;

    localStorage.setItem('city', JSON.stringify(city));

    // localStorage.setItem('customer', JSON.stringify(customer));

    fetch("http://localhost:8088/organicoasis/registercustomeraddress/1", {

        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify({
            "flatNo": flatno,
            "buildingName": building,
            "area": area,
            "city": city,
            "pincode": Pincode
        })
    }).then(response => {
        if(response.status == 201 | response.status == 200){
            response.json().then(data => {
                alert("Address sucessfully registered")
                console.log(data);
            });
        }else{
            response.json().then(data => alert(data.message));
        }
    })

    alert("Address added successfully")

    // window.location.href = "AddAdress.html";
    window.location.href = "file:///C:/Users/Soumit/OneDrive/Desktop/New%20pull%20code/icky-thunder-5613/OrganicOasis_FrontEnd/Render.html";
}