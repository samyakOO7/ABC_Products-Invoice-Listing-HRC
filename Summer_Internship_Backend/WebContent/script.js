let add = document.getElementsByClassName("nav-btn add-btn");
let edit = document.getElementsByClassName("nav-btn edit-btn");
let del = document.getElementsByClassName("nav-btn delete-btn");

document.addEventListener("click", (e) => {
	// console.log(e.target.classList);
	// console.log(e.target.id);
	if (
		e.target.classList.contains("container") ||
		e.target.classList.contains("content") ||
		e.target.classList.contains("page-btn") ||
		e.target.classList.contains("logo") ||
		e.target.id == "table"
	) {
		let modal1 = document.getElementsByClassName("modal 1");
		let modal2 = document.getElementsByClassName("modal 2");
		let modal3 = document.getElementsByClassName("modal 3");
		modal1[0].style.display = "none";
		modal2[0].style.display = "none";
		modal3[0].style.display = "none";
		add[0].disabled = false;
		edit[0].disabled = false;
		del[0].disabled = false;
	}
});

add[0].addEventListener("click", (e) => {
	// console.log(add[0].disabled);
	let modal = document.getElementsByClassName(e.target.getAttribute("href"));
	modal[0].style.display = "grid";
	add[0].disabled = true;
	edit[0].disabled = true;
	del[0].disabled = true;
});
edit[0].addEventListener("click", (e) => {
	let modal = document.getElementsByClassName(e.target.getAttribute("href"));
	modal[0].style.display = "grid";
	add[0].disabled = true;
	edit[0].disabled = true;
	del[0].disabled = true;
});
del[0].addEventListener("click", (e) => {
	let modal = document.getElementsByClassName(e.target.getAttribute("href"));
	modal[0].style.display = "grid";
	add[0].disabled = true;
	edit[0].disabled = true;
	del[0].disabled = true;
});

let cross = document.getElementsByClassName("cross");
for (let i = 0; i < 3; i++) {
	cross[i].addEventListener("click", () => {
		add[0].disabled = false;
		edit[0].disabled = false;
		del[0].disabled = false;
		let modal = document.getElementsByClassName("modal");
		for (let j = 0; j < 3; j++) {
			modal[j].style.display = "none";
		}
	});
}

let cancel = document.getElementsByClassName("subbtn cancel");
for (let i = 0; i < 3; i++) {
	cancel[i].addEventListener("click", () => {
		add[0].disabled = false;
		edit[0].disabled = false;
		del[0].disabled = false;
		let modal = document.getElementsByClassName("modal");
		for (let j = 0; j < 3; j++) {
			modal[j].style.display = "none";
		}
	});
}

let clear = document.getElementsByClassName("subbtn reset");
for (let i = 0; i < 2; i++) {
	clear[i].addEventListener("click", () => {
		let inp = document.getElementsByTagName("input");
		for (let j = 0; j < inp.length; j++) {
			if (inp[j].classList.length == 0) {
				inp[j].value = "";
			}
		}
		inp = document.getElementsByTagName("textarea");
		for (let j = 0; j < inp.length; j++) {
			inp[j].value = "";
		}
	});
}
