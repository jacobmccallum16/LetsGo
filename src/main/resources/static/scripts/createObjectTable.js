function createObjectTableString(object) {
    let html = `
	<div class="col col-auto">
	<table class="table mx-auto">
		<thead class="table-green">
			<tr><th colspan="2">Trip</th></tr>
		</thead>
		<tbody>`;
    for (let key in object) {
        html += `<tr> <td>${key}</td> <td>${object[key]}</td> </tr>`;
    }
    html += `
			</tbody>
		</table>
    </div>`;
    return html;
}