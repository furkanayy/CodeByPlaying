from flask import Flask
import pickle

app = Flask(__name__)

@app.route('/mutluet/<number>',methods=['GET', 'POST'])
def mutluet(number):
        vect = pickle.load(open('vect.pkl','rb'))
        prediction = mutluet.predict(vect.transform([number]))  
        return str(prediction)

@app.route('/akillisinif/<number>',methods=['GET', 'POST'])
def akillisinif(number):
        vect = pickle.load(open('akillisinif.pkl','rb'))
        prediction = akillisinif.predict(vect.transform([number]))  
        return str(prediction)

@app.route('/manset/<number>',methods=['GET', 'POST'])
def manset(number):
        vect = pickle.load(open('manset.pkl','rb'))
        prediction = manset.predict(vect.transform([number]))  
        return str(prediction)

@app.route('/sapka/<number>',methods=['GET', 'POST'])
def sapka(number):
        vect = pickle.load(open('sapka.pkl','rb'))
        prediction = sapka.predict(vect.transform([number]))  
        return str(prediction)

@app.route('/turist/<number>',methods=['GET', 'POST'])
def turist(number):
        vect = pickle.load(open('turist.pkl','rb'))
        prediction = turist.predict(vect.transform([number]))  
        return str(prediction)

if __name__  == '__main__':
    mutluet = pickle.load(open('model.pkl','rb'))
    akillisinif = pickle.load(open('model2.pkl','rb'))
    manset = pickle.load(open('model3.pkl','rb'))
    sapka = pickle.load(open('model4.pkl','rb'))
    turist = pickle.load(open('model5.pkl','rb'))
    app.run(host="192.168.1.3", port=5000,debug=True)