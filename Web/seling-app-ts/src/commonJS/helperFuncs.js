export const isEmpty = value =>

    value === undefined ||

    value === null ||

    (typeof value === "object" && Object.keys(value).length === 0) ||

    (typeof value === "string" && value.trim().length === 0);

export const subString = (text, maxLength = 50) => {
    if (!isEmpty(text)) {
        let len = text.length;

        if (len <= maxLength) {
            return text;
        }
        return text.substr(0, maxLength) + "...";
    }
}

export const formatMoney = (money) => {
    return (money + "").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
} 