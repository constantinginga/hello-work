using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data
{
    public class JobListingData : IJobListingData
    {
        private HttpClient client;
        public IList<JobListing> JobListings { get; private set; }
        private const string _url = "";

        public JobListingData()
        {
            client = new();
            JobListings = new List<JobListing>();
        }

        public async Task Create(JobListing jobListing)
        {
            // store locally
            int max = JobListings.Count != 0 ? JobListings.Max(j => j.Id) : 0;
            jobListing.Id = ++max;
            JobListings.Add(jobListing);


            // store in server
            /*StringContent queryString = new(JsonConvert.SerializeObject(adult), Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.PostAsync(_url, queryString);
            response.EnsureSuccessStatusCode();*/
        }
        public async Task<IList<JobListing>> GetJobListings()
        {
            return JobListings;
        }

        public async Task Update(JobListing jobListing)
        {
            JobListing toUpdate = JobListings.First(j => j.Id == jobListing.Id);
            toUpdate.Details = jobListing.Details;

            /*StringContent queryString = new(JsonConvert.SerializeObject(adult), Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.PatchAsync(_url + $"/{adult.Id}", queryString);
            response.EnsureSuccessStatusCode();*/
        }

        public JobListing Get(int id)
        {
            return JobListings.FirstOrDefault(j => j.Id == id);
        }
    }
}
