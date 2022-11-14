// Select size input
const height = document.getElementById('inputHeight');
const width = document.getElementById('inputWidth');
const table = document.getElementById('pixelCanvas');
makeGrid(height, width);

// When size is submitted by the user, call makeGrid()
document.querySelector('form').addEventListener('submit', function(event) {
	event.preventDefault();
	table.firstChild.remove();
	makeGrid(height, width);
})

/**
 * @desc Creates the grid for pixel art work
 * @param int $width - number of squares/block representing the width of the grid
 * @param int $height - number of squares/block representing the height of the grid
 */
function makeGrid(height, width) {
	// Your code goes here! 
	const colorPicker = document.getElementById('colorPicker');
	for (let i = 0; i < height.value; i++) {
		let row = table.insertRow(i);
		for (let j = 0; j < width.value; j++) {
			let cell = row.insertCell(j);
			// Color input when user click a cell
			cell.addEventListener("click", function(event) {
				var clickCell = event.target;
				clickCell.style.backgroundColor = colorPicker.value;
			})
		}
	}
}