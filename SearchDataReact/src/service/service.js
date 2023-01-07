


export const get=()=>{
    fetch('http://localhost/console/scene/scenedetaillist',{
        method:'GET',
        headers:{
            'Content-Type':'application/json;charset=UTF-8'
        },
        mode:'cors',
        cache:'default'
    })
}