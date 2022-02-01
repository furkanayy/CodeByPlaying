import pandas as pd
import pickle
import joblib

# Verinin Okunması #s
column = ['cümle']
df = pd.read_csv('turist.csv',encoding = 'utf-8',sep = '"')
df.columns = column
df.info()
#Veri setindeki Türkçe Dolgu kelimlerinin kaldırılması 
def remove_stopwords(df_fon):
    stopwords = open('turkce-stop-words','r').read().split()
    df_fon['stopwords_removed'] = list(map(lambda doc:
        [word for word in doc if word not in stopwords],df_fon['cümle']))

remove_stopwords(df)

#sayısallaştırma: 1 Fan Açık 2 Fan Kapalı 3 Işık Açık 4 Işık Kapalı
df['Sinif'] = 1
df.Sinif.iloc[18:29] = 2
df.Sinif.iloc[29:39] = 3
df.Sinif.iloc[39:50] = 4
df.Sinif.iloc[50:61] = 5

from sklearn.model_selection import train_test_split
X_train,X_test,Y_train,Y_test = train_test_split(df['cümle'],df['Sinif'],test_size = 0.3,random_state = 0)

from sklearn.feature_extraction.text import CountVectorizer
vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)
joblib.dump(vect, 'turist.pkl')

#X_Train'deki belgeleri bir belge terim matrisine dönüştürüyoruz
X_train_vectorizer = vect.transform(X_train)


from sklearn.linear_model import LogisticRegression
regressor = LogisticRegression()
regressor.fit(X_train_vectorizer , Y_train)

pickle.dump(regressor, open('model5.pkl', 'wb'))  