var pageno=1;
var url ="http://localhost:8080/Summer_Internship_Backend/fetch?page="
const Rendertable = (data) =>{
    var row='';

    data.map(d=>{
         row+= 
        `<tr>
            <td><input type="checkbox" /></td>
            <td>${d.custname}</td>
            <td>${d.custnumber}</td>
            <td>${d.invoice}</td>
            <td>${d.amt}</td>
            <td>${d.duedate}</td>
            <td>${d.cleardate}</td>
            <td>${d.notes}</td>
        </tr>` 
    })
  console.log(row);
    $('tbody').empty().append(row)
}

const prev =async() =>{
    if(pageno<2) return;
    pageno-=1

    const resp = await fetch(url+pageno.toString(),{
        header: {
            'Access-Control-Allow-Origin':'*',
          },
          mode:'cors',
    });
    const body = await resp.json()
    // document.write(body)
    Rendertable(body)
} 

const next =async() =>{
    if(pageno>1000) return;
    pageno+=1

    const resp = await fetch(url+pageno.toString(),{
        header: {
            'Access-Control-Allow-Origin':'*',
          },
          mode:'cors',
    });
    const body = await resp.json()
    // document.write(body)
    Rendertable(body)
} 

$(document).ready(async function(){
    const resp = await fetch(url+pageno.toString(),{
        header: {
            'Access-Control-Allow-Origin':'*',
          },
          mode:'cors',
    });
    const body = await resp.json()
    Rendertable(body)
})