
export const get=url=>{
   return fetch(url,{
        method:'GET',
        headers:{
            'Content-Type':'application/json;charset=UTF-8'
        },
        mode:'cors',
        cache:'default'
    })
}