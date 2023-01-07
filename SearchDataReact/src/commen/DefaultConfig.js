export const getUrl = () => {
    if (process.env.NODE_ENV === 'development') {
        return 'http://localhost:9010';
    } else {
        return 'http://106.13.238.92:9010';

    }
};

export const fetchPost = (base, url) => {
    const headers = new Headers({
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Credentials': '*',
    });
    const opts = {
        method: "POST",
        mode: 'cors',
        body: JSON.stringify(base),
        headers
    };
    return fetch(`${getUrl()}${url}`, opts);

};