export async function deleteTask(id) {
    const response = await fetch(`/api/v1/mytask/delete/${id}`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
    });
    return await response.json();
}

export async function createDictEntry(entry) {
        return fetch(`api/v1/dict-entry/create`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(entry)
        }).then(((response) =>{
            return response.text();
        }));
}


export async function getDictEntries() {
    return fetch(`api/v1/dict-entry/all`, {
        method: "GET",
        headers: {"Content-Type": "application/json"},
    }).then(((response) =>{
        return response.json();
    }));
}

export async function deleteDictEntry(id) {
    return fetch(`/api/v1/dict-entry/delete/${id}`, {
        method: "DELETE",
        headers: {"Content-Type": "application/json"},
    }).then(((response) =>{
        return response.text();
    }));
}

