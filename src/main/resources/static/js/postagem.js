
function clique(){
	let campo = document.getElementById('campo').value;
	
	let data = {
			"postagem" : postagem,
			};
			
			fetch("/postagem", {
				method: "POST",
				headers : {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(data)
				
			}).then(function(response){
				createTable();
				
			}).catch(function(error) {
				console.log(error);
			})
}


function createTable(){
	fetch("/postagem")
		.then(function(response){
		if(response.status >= 200 && response.status <= 300){
			
			response.json()
				.then(function(data){
					
					let tb = document.getElementById("postagem");
					tb.innerHTML =  "<tr><th> postagem </th></tr>"
						
					for(let i = 0; i < data.content.length;i++){
						

						let k = data.content[i];
						tb.innerHTML += `<tr><th>${k.postagem}</th></tr>`;
					}
				})
		}
	}).catch(function(error) {
		console.log(error);
	});
}

createTable();