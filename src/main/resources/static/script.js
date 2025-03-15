function appendNumber(num) {
    let inputField = document.getElementById("inputNumber");
    fetch('/editor/digit', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'value=' + num
    })
        .then(response => response.text())
        .then(data => {
            console.log('Data from server:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    if (inputField.value === "0") {
        inputField.value = num;
    } else {
        inputField.value += num;
    }
}

function backspaceButton() {
    let inputField = document.getElementById("inputNumber");

    if (inputField.value !== "") {
        inputField.value = inputField.value.slice(0, -1);
    }
    fetch('/editor/bs', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
        .then(response => response.text())
        .then(data => {
            console.log('Data from server:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });

}


function clearInput() {
    document.getElementById("inputNumber").value = "0";
}

function updateButtons() {
    let base = parseInt(document.getElementById("sourceBase").value, 10);

    document.querySelectorAll(".buttons button.num").forEach(button => {
        let value = button.innerText;

        // Проверяем, является ли символ буквой (A-F)
        let isLetter = isNaN(value);
        let isDisabled = isLetter ? (value.charCodeAt(0) - 55 >= base) : (parseInt(value, 10) >= base);

        if (isDisabled) {
            button.classList.add("disabled");
            button.disabled = true;
        } else {
            button.classList.remove("disabled");
            button.disabled = false;
        }
    });
}

// Событие при изменении числа системы счисления
document.getElementById("sourceBase").addEventListener("change", updateButtons);
document.addEventListener("DOMContentLoaded", updateButtons);


